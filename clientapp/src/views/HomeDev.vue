<template>
  <div>Welcome {{ user.username }} !!</div>
</template>

<script>
import UserService from "../services/userService.js";

export default {
  data() {
    return {
      userService: new UserService(this.$router),
    };
  },
  computed: {
    user() {
      return this.userService.getAuthenticatedUser();
    },
  },
};
</script>

<style>
</style>