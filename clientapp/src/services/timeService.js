const axios = require("axios").default;

export default class TimeService {
    constructor() {
        this._instance = axios.create({
            baseURL: 'http://localhost:8091'
        });

        console.log("Time Service built.");
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