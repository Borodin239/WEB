<template>
  <tr>
    <td class="id">{{user.id}}</td>
    <td class="login">{{user.login}}</td>
    <td class="name">{{user.name}}</td>
  </tr>
</template>

<script>
export default {
  name: "UserRow",
  props: ["user"]
}
</script>

<style scoped>

</style>