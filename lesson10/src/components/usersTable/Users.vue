<template>
  <div class="users datatable">
    <div class="caption">User</div>
    <table>
      <thead>
      <tr>
        <th>Id</th>
        <th>Login</th>
        <th>Name</th>
      </tr>
      </thead>
      <tbody> <UserRow v-for="user in users" :user="user" :key="user.id"/> </tbody>
    </table>
  </div>
</template>

<script>
import UserRow from "@/components/usersTable/UserRow";

export default {
  name: "Users",
  components: {
    UserRow
  },
  props: ["users"]
}
</script>

<style scoped>

</style>