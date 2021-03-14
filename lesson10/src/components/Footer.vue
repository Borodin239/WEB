<template>
  <footer>
    <div> Written posts: {{postsNumber}}</div>
    <div> Users: {{usersNumber}}</div>
    <a href="/">Codeforces</a> &copy; 2020 by Mike Mirzayanov
  </footer>
</template>

<script>
export default {
  name: "Footer",
  props: ["usersNumber", "postsNumber"]
}
</script>

<style scoped>

</style>