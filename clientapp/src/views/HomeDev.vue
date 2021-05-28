<template>
  <div class="container">
    <h4 class="my-4">Bienvenue, {{ user.username }}</h4>
    <div class="row">
      <div class="col-10">
        <div class="month-select row">
          <div class="col-12">
            <b-button pill @click="goToPreviousMonth" variant="outline-secondary">&lt;</b-button>
            <span class="month-display">Janvier 2021</span>
            <b-button pill @click="goToNextMonth" variant="outline-secondary">&gt;</b-button>
          </div>
        </div>
        <div class="append-project row mt-3">
          <div class="col-4">
            <b-form-select
              class="rounded-pill"
              v-model="selectedProject"
              :options="projectsList"
            ></b-form-select>
          </div>
          <div class="col">
            <b-button pill variant="outline-secondary">Ajouter</b-button>
          </div>
        </div>
      </div>
      <div class="col-2 action-group text-right">
        <b-button pill class="btn-action my-1">Export PDF</b-button>
        <b-button pill variant="primary" class="btn-action my-1"
          >Verrouiller</b-button
        >
      </div>
    </div>
    <div class="display-projects"></div>
  </div>
</template>

<script>
import UserService from "../services/userService";
import ProjectService from "../services/projectService";
import TimeService from "../services/timeService";

export default {
  data() {
    return {
      userService: new UserService(this.$router),
      projectService: new ProjectService(),
      timeService: new TimeService(),
      selectedProject: null,
      timeSaisies: [],
      currentMonth: new Date()
    };
  },
  computed: {
    user() {
      return this.userService.getAuthenticatedUser();
    },
    projectsList() {
      let tmp = this.projectService.getAllProjects().map((x) => {
        return {
          value: x,
          text: x.nom,
        };
      });
      tmp.unshift({
        value: null,
        text: "Sélectionner un projet",
        disabled: true,
      });
      return tmp;
    },
  },
  // mounted(){
  //   let mnth = this.timeService.getMonthByUserId(this.currentMonth, 0);
  //   if (mnth){
  //     this.timeSaisies = mnth.timeSaisies;
  //   }
  // }, 
  methods:{
    goToNextMonth(){

    },
    goToPreviousMonth(){

    }
  }
};
</script>

<style>
.month-display {
  padding: 0 20px;
  font-size: 18px;
}
</style>