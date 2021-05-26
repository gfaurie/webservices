<template>
  <div id="navbar">
    <b-navbar>
      <b-navbar-brand href="#">Time Management</b-navbar-brand>
      <!-- Align items to the left -->
      <b-navbar-nav class="ml-auto">
        <b-nav-item
          v-if="isAuthenticated"
          v-on:click="onDisconnect"
        >
          Se déconnecter
        </b-nav-item>
        <b-nav-item
          v-if="!isAuthenticated"
          v-on:click="onGoAuth"
        >
          Se connecter
        </b-nav-item>
      </b-navbar-nav>
    </b-navbar>
  </div>
</template>

<script>
import UserService from "../services/userService";

export default {
  name: "Navbar",
  data() {
    return {
      userService: new UserService(this.$router),
      refreshBackDoor: 0,
    };
  },
  computed: {
    isAuthenticated() {
      this.refreshBackDoor;
      return this.userService.isAuthenticated();
    },
  },
  methods: {
    onGoAuth() {
      this.$router.push("/login");
    },
    onDisconnect() {
      this.userService.disconnect();
      this.refreshBackDoor++;
    },
  },
};
</script>

<style>
.navbar {
  background-color: #945656;
}
a.navbar-brand {
  color: white !important;
}
a.nav-link {
  padding-left: 10px;
  padding-right: 10px;
  color: white !important;
  border-radius: 50rem;
}
a.nav-link:hover {
  color: white !important;
  text-decoration: none;
  background: linear-gradient(rgba(0, 0, 0, 0.1), rgba(0, 0, 0, 0.1));
}
</style>