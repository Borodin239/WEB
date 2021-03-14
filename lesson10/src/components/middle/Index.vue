<template>
  <div>
    <Post v-for="post in posts" :post="post" :users="users" :needToShowComments="false"
          :commentsNumber="commentsNumbers[post.id]" :key="post.id"/>
  </div>
</template>

<script>
import Post from "@/components/middle/Post";
export default {
  name: "Index",
  props: ["posts", "commentsNumbers", "users"],
  components: {
    Post
  }
}
</script>

<style scoped>
</style>
