<template>
  <div class="container">
    <h4 class="my-4">Bienvenue, {{ user.username }}</h4>
    <div class="row">
      <div class="col-10">
        <div class="month-select row">
          <div class="col">
            <b-button
              pill
              @click="goToPreviousMonth"
              variant="outline-secondary"
              >&lt;</b-button
            >
            <span class="month-display">{{ dateToString }}</span>
            <b-button pill @click="goToNextMonth" variant="outline-secondary"
              >&gt;</b-button
            >
            <span
              class="month-display"
              v-bind:class="{ 'not-valid': remainingHours < 0 }"
              v-if="monthData != null"
            >
              Solde : {{ remainingHours }}/{{ monthData.nbHour }} heures
            </span>
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
          <div class="col-2">
            <b-input-group append="h">
              <b-form-input
                v-model="selectedProjectTime"
                type="text"
                class="semi-round"
                @input="emitUsername"
              ></b-form-input
            ></b-input-group>
          </div>
          <div class="col">
            <b-button pill @click="addTimeToList" variant="outline-secondary"
              >Ajouter</b-button
            >
          </div>
        </div>
      </div>
      <div class="col-2 action-group text-right">
        <b-button pill class="btn-action my-1">Export PDF</b-button>
        <b-button
          pill
          variant="primary"
          class="btn-action my-1"
          v-bind:disabled="remainingHours < 0"
          >Verrouiller</b-button
        >
      </div>
    </div>
    <hr class="mt-4" />
    <div class="display-projects mt-4">
      <h4 class="mb-3">Mes projets</h4>
      <!-- <added-project
        v-for="time in monthData.timePerProjectAndMonths"
        :key="time.id"
      ></added-project> -->
      <div class="m-2" v-if="monthData.timePerProjectAndMonths.length == 0">
        Aucune saisie de temps pour le moment !
      </div>
      <div
        class="row m-2"
        v-for="time in monthData.timePerProjectAndMonths"
        :key="time.id"
      >
        {{ projectsList.find((x) => x.id == time.idProject).text }} -
        {{ time.nbHours }} heures
        <b-button pill class="ml-2 mr-1" variant="outline-secondary"
          ><b-icon-pencil></b-icon-pencil></b-button
        ><b-button
          pill
          class="mx-2"
          variant="outline-primary"
          @click="deleteTime(time.idProject)"
          ><b-icon-trash></b-icon-trash
        ></b-button>
      </div>
    </div>
  </div>
</template>

<script>
import UserService from "../services/userService";
import ProjectService from "../services/projectService";
import TimeService from "../services/timeService";
// import AddedProject from "../components/AddedProject";

export default {
  components: {
    // AddedProject,
  },
  data() {
    return {
      userService: new UserService(this.$router),
      projectService: new ProjectService(),
      timeService: new TimeService(),
      selectedProject: null,
      selectedProjectTime: 0,
      monthData: {},
      currentMonthDate: new Date(),
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
          id: x.id_project,
        };
      });
      tmp.unshift({
        value: null,
        text: "Sélectionner un projet",
        id: null,
        disabled: true,
      });
      return tmp;
    },
    remainingHours() {
      let sum = 0;
      this.monthData.timePerProjectAndMonths.forEach((element) => {
        sum += element.nbHours;
      });
      return this.monthData.nbHour - sum;
    },
    dateToString() {
      return this.timeService.mapDateMonthName(this.monthData.startDate);
    },
  },
  mounted() {
    let mnth = this.timeService.getMonthByUserId(this.currentMonth, 0);
    if (mnth) {
      this.monthData = mnth;
      this.currentMonthDate = new Date(mnth.startDate);
    }
  },
  methods: {
    goToNextMonth() {
      this.currentMonthDate = this.currentMonthDate.setMonth(
        this.currentMonthDate.getMonth() + 1
      );
    },
    goToPreviousMonth() {
      this.currentMonthDate = this.currentMonthDate.setMonth(
        this.currentMonthDate.getMonth() - 1
      );
    },
    addTimeToList() {
      let a = this.monthData.timePerProjectAndMonths.find(
        (x) => x.idProject == this.selectedProject.id_project
      );
      if (a != null) {
        let i = this.monthData.timePerProjectAndMonths.indexOf(a);
        this.monthData.timePerProjectAndMonths[i].nbHours =
          this.monthData.timePerProjectAndMonths[i].nbHours +
          parseInt(this.selectedProjectTime);
      } else {
        this.monthData.timePerProjectAndMonths.push({
          id: null,
          idProject: this.selectedProject.id_project,
          nbHours: parseInt(this.selectedProjectTime),
        });
      }
    },
    deleteTime(prId) {
      let a = this.monthData.timePerProjectAndMonths.find(
        (x) => x.projectId == prId
      );
      let i = this.monthData.timePerProjectAndMonths.indexOf(a);
      this.monthData.timePerProjectAndMonths.splice(i);
    },
  },
};
</script>

<style>
.month-display {
  padding: 0 20px;
  font-size: 18px;
}
input.semi-round {
  border-radius: 50rem 0 0 50rem;
}
.display-projects > div {
  font-size: 18px;
}
button.btn-outline-primary {
  color: #945656;
  border-color: #945656;
}
button.btn-outline-primary:hover,
button.btn-primary:disabled {
  background-color: #945656;
  border-color: #945656;
}
.not-valid {
  color: #945656;
}
</style>