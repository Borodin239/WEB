<template>
  <div class="middle">
    <Sidebar :posts="viewPosts"/>
    <main>
      <Index v-if="page === 'Index'" :posts="sortedPosts" :users="users"
             :commentsNumbers="getCommentsNumbers"/>
      <Enter v-if="page === 'Enter'"/>
      <Register v-if="page === 'Register'"/>
      <WritePost v-if="page === 'WritePost'"/>
      <EditPost v-if="page === 'EditPost'"/>
      <Users v-if="page === 'Users'" :users="users"/>
      <Post v-if="page === 'Post'" :post="post" :users="users" :comments="getComments(post)"
            :needToShowComments="true" :commentsNumber="getComments(post).length"/>
    </main>
  </div>
</template>

<script>
import Sidebar from "@/components/sidebar/Sidebar";
import Index from "@/components/middle/Index";
import Enter from "@/components/middle/Enter";
import Register from "@/components/middle/Register";
import WritePost from "@/components/middle/WritePost";
import EditPost from "@/components/middle/EditPost";
import Users from "@/components/usersTable/Users";
import Post from "@/components/middle/Post";

export default {
  name: "Middle",
  needToShowComments: false,
  data: function () {
    return {
      page: "Index",
      post: undefined
    }
  },
  components: {
    WritePost,
    Enter,
    Register,
    Index,
    Users,
    Sidebar,
    EditPost,
    Post
  },
  props: ["posts", "users", "comments"],
  methods: {
    getComments: function (post) {
      return Object.values(this.comments).filter(comment => comment.postId === post.id)
    },
  },
  computed: {
    getCommentsNumbers: function () {
      let ids = {};
      Object.values(this.comments).forEach(comment => {
        if (ids[comment.postId] === undefined) {
          ids[comment.postId] = 1;
        } else {
          ids[comment.postId]++;
        }
      })
      return ids;
    },
    viewPosts: function () {
      return Object.values(this.posts).sort((a, b) => b.id - a.id).slice(0, 2);
    },
    sortedPosts: function () {
      return Object.values(this.posts).sort((a, b) => b.id - a.id);
    },
  }, beforeCreate() {
    this.$root.$on("onChangePage", (page) => {
      this.page = page;
      this.$forceUpdate();
    })

    this.$root.$on("onPost", (post) => {
      this.post = post;
      this.$root.$emit("onChangePage", "Post")
    });
  }
}
</script>

<style scoped>

</style>