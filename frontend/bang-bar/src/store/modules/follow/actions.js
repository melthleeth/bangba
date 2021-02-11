const SERVER_URL = process.env.VUE_APP_SERVER_URL;
export default {
    async isFollow(context, payload) {
        const user_info = {
            user_no : context.rootGetters.pkUser,
            target_no : payload.target_no
        };
        const response = await fetch(`${SERVER_URL}/user/isfollow`, {
            headers: {
                "Content-Type": "application/json; charset=utf-8",
                'Accept': '*/*',
                'Access-Control-Allow-Origin': '*',
                'Access-Control-Allow-Headers': '*',
            },
            method: "POST",
            body: JSON.stringify(userInfo)
        });
        const responseData = await response.text();
        if(parseInt(responseData) == 1) {
            context.commit("setIsFollow", true);
        } else if(parseInt(responseData) == 0) {
            context.commit("setIsFollow", false);
        } else {
            alert("팔로우 호출이 잘못되었습니다.");
        }
    },
    async follow(context, payload) {
        const userInfo = {
            user_no : context.rootGetters.pkUser,
            target_no : payload.target_no
        };
        const response =await fetch(`${SERVER_URL}/user/follow`,{
            headers: {
                "Content-Type": "application/json; charset=utf-8",
                'Accept': '*/*',
                'Access-Control-Allow-Origin': '*',
                'Access-Control-Allow-Headers': '*',
            },
            method: "POST",
            body: JSON.stringify(userInfo)
        });
        const responseData = await response.text();

        if(responseData == "success") {
            context.commit("setIsFollow", true);
        } else {
            alert("팔로우 실패");
        }
    },
    async unfollow(context, payload) {
        const userInfo = {
            user_no : context.rootGetters.pkUser,
            target_no : payload.target_no
        };
        const response =await fetch(`${SERVER_URL}/user/unfollow`,{
            headers: {
                "Content-Type": "application/json; charset=utf-8",
                'Accept': '*/*',
                'Access-Control-Allow-Origin': '*',
                'Access-Control-Allow-Headers': '*',
            },
            method: "POST",
            body: JSON.stringify(userInfo)
        });
        const responseData = await response.text();

        if(responseData == "success") {
            context.commit("setIsFollow", false);
        } else {
            alert("팔로우 실패");
        }
    },
    async setFollowCnt(context, payload) {
        const response = await fetch(`${SERVER_URL}/user/follow`+ context.rootGetters.pkUser + `/ec`,{
            headers: {
                "Content-Type": "application/json; charset=utf-8",
                'Accept': '*/*',
                'Access-Control-Allow-Origin': '*',
                'Access-Control-Allow-Headers': '*',
            },
            method: "GET"
        });

        const responseData = await Response.text();
        context.commit("setFollowCnt", parseInt(responseData));
    },
    async setFollowingCnt(context, payload) {
        const response = await fetch(`${SERVER_URL}/user/follow`+ context.rootGetters.pkUser + `/ic`,{
            headers: {
                "Content-Type": "application/json; charset=utf-8",
                'Accept': '*/*',
                'Access-Control-Allow-Origin': '*',
                'Access-Control-Allow-Headers': '*',
            },
            method: "GET"
        });
        const responseData = await Response.text();
        context.commit("setFollowingCnt", parseInt(responseData));
    }
};