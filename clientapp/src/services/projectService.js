export default class ProjectService {
    constructor() {
        console.log("Project service built.");
    }

    getAllProjects() {
        return [{
            id_project: 0,
            nom: "CGA",
            time: 500,
            description: "Espace commun v2, c#, Angular"
        }, {
            id_project: 1,
            nom: "Limagrain - Hendrix",
            time: 43,
            description: "Application de gestion de projets, ASP.NET, Jquery"
        }, {
            id_project: 2,
            nom: "FEI - Adele",
            time: 2000,
            description: "France education international, en cours de dev, c#, Blazor"
        }]
    }
}