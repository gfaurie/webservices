export default class ProjectService {
    constructor() {
        console.log("Project service built.");
    }

    getAllProjects() {
        return [{
            id_project: 0,
            nom: "Projet Web Services",
            time: 500,
            description: "VueJS, Rest, Soap, Java"
        }, {
            id_project: 1,
            nom: "Big Data Project",
            time: 43,
            description: "CV Predictor, AWS"
        }, {
            id_project: 2,
            nom: "Mecanique de vol capteurs",
            time: 2000,
            description: "C, FreeRTOS, Tasks, Queues, Semaphores"
        }]
    }
}