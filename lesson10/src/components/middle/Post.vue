<template>
  <div>
    <article>
      <a href="#" style="text-decoration: none" @click.prevent="onPost">
        <div class="title">{{ post.title }}</div>
      </a>
      <div class="information">By {{ users[post.userId].login }}</div>
      <div class="body">{{ post.text }}</div>
      <ul class="attachment">
        <li>Announcement of <a href="#">Codeforces Round #510 (Div. 1)</a></li>
        <li>Announcement of <a href="#">Codeforces Round #510 (Div. 2)</a></li>
      </ul>
      <div class="footer">
        <div class="left">
          <img src="../../assets/img/voteup.png" title="Vote Up" alt="Vote Up"/>
          <span class="positive-score">+173</span>
          <img src="../../assets/img/votedown.png" title="Vote Down" alt="Vote Down"/>
        </div>
        <div class="right">
          <img src="../../assets/img/date_16x16.png" title="Publish Time" alt="Publish Time"/>
          A while ago
          <img src="../../assets/img/comments_16x16.png" title="Comments" alt="Comments"/>
          <a href="#">{{ commentsNumber === undefined ? 0 : commentsNumber }}</a>
        </div>
      </div>
      <template v-if="needToShowComments">
        <div class="comment" v-for="comment in comments" :key="comment.id">
          <div>User: {{ users[comment.userId].login }}</div>
          <div>Text: {{ comment.text }}</div>
        </div>
      </template>
    </article>
  </div>
</template>

<script>
export default {
  name: "Post",
  props: ["post", "users", "comments", "commentsNumber", "needToShowComments"],
  methods: {
    onPost: function () {
      this.$root.$emit("onPost", this.post);
    }
  },
}
</script>

<style scoped>
.comment {
  margin-bottom: 0.5rem;
}
</style>