<template>
  <div id="app">
    <div id="nav">
      <Navbar />
    </div>
    <router-view/>
    <div id="foot">
      <!--TODO Etienne footer or not ?-->
    </div>
  </div>
</template>

<script>
import Navbar from './components/Navbar';
export default {
  name: 'app', 
  components: {
    Navbar
  }
}
</script>

<style>
</style>
