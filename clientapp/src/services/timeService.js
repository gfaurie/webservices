const axios = require("axios").default;

export default class TimeService {
    constructor() {
        this._instance = axios.create({
            baseURL: 'http://localhost:8091'
        });

        this.monthDictionary = {
            1: "Janvier",
            2: "Février",
            3: "Mars",
            4: "Avril",
            5: "Mai",
            6: "Juin",
            7: "Juillet",
            8: "Août",
            9: "Septembre",
            10: "Octobre",
            11: "Novembre",
            12: "Décembre",
        };
        console.log("Time Service built.");
    }

    mapDateMonthName(date) {
        let date2Date = new Date(date);
        let month = date2Date.getMonth() + 1;
        let year = date2Date.getFullYear();
        let stringMonth = `${this.monthDictionary[month]} ${year}`
        return stringMonth;
    }

    getMonthByUserId(monthDate, userId) {
        console.log("Request for " + monthDate + " and " + userId);
        return {
            idMonth: 0,
            idUser: 0,
            nbHour: 140,
            startDate: "2021-05-01",
            endDate: "2021-05-31",
            isLocked: false,
            timePerProjectAndMonths: [{
                    id: 0,
                    idProject: 0,
                    nbHours: 50
                },
                {
                    id: 1,
                    idProject: 2,
                    nbHours: 40
                }
            ]
        };
    }

    // TODO Implement
    async updateTime(time) {
        try {
            const response = await this.instance.put(`/times/${time.id}`, {

                "idProject": time.idProject,
                "nbHour": time.nbHour,
                "idMonth": time.idMonth
            });
            if (response) {
                console.log("Time successfully inserted");
            }
        } catch (error) {
            console.error("Error while inserting time " + error);
        }
    }

    // goToNextMonth(currentDate) {
    //     return {};
    // }

    // goToPreviousMonth(currentDate) {
    //     return {};
    // }
    // TODO
}