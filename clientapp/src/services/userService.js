export default class UserService {
    constructor(router) {
        this._router = router;
        console.log("User Service built.")
    }

    authenticate(userForm) {
        let isMgr = false;
        if (userForm.username && userForm.password) {
            localStorage.setItem("authenticatedUser", userForm.username);
            localStorage.setItem("authenticatedUserIsManager", isMgr);
            this._router.push(isMgr ? 'homemanager' : 'homedev');
        }
    }

    disconnect() {
        if (this.isAuthenticated()) {
            localStorage.removeItem("authenticatedUser");
            localStorage.removeItem("authenticatedUserIsManager");
            this._router.push('login');
        }
    }

    isAuthenticated() {
        return localStorage.getItem("authenticatedUser") != null;
    }

    getAuthenticatedUser() {
        return {
            username: localStorage.getItem("authenticatedUser"),
            isManager: localStorage.getItem("authenticatedUserIsManager") == 'true'
        };
    }
}