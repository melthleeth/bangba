const SERVER_URL = process.env.VUE_APP_SERVER_URL;
export default {
    // 버튼이 눌러져있는지 판단 
    async isClick(context, payload) {
        let url = "";
        // 만약 누른 버튼이 like라면
        if(payload.isLike == ture) {
            url = `${SERVER_URL}/is-like`;
        } else {
            url = `${SERVER_URL}/is-bmark`;
        }
        const userInfo = {
            user_no : context.rootGetters.pkUser,
            article_no : payload.article_no,
        }

        const response = await fetch(url, {
            headers: {
                "Content-Type": "application/json; charset=utf-8",
                'Accept': '*/*',
                'Access-Control-Allow-Origin': '*',
                'Access-Control-Allow-Headers': '*',
            },
            method: "POST",
            body: JSON.stringify(userInfo)
        });
        // 만약 쿼리가 실행됐으면 -1 이상의 값이 반환
        // 눌렀으면 1, 안눌렀으면 0
        const responseData = await response.text();
        
        if(responseData == 0) { 
            // 버튼이 눌러져있지 않다.
        } else if(responseData == 1) {
            // 버튼이 눌려져있다.
        } else {
            alert("페이지 로드에 문제가 생겼습니다.");
        }
    }, 

    // 좋아요 혹은 북마크를 누르면 내 계정에 추가 
    async clickBtn(context, payload) {
        let url = "";
        // 만약 누른 버튼이 like라면
        if(payload.isLike == ture) {
            url = `${SERVER_URL}/is-like`;
        } else {
            url = `${SERVER_URL}/is-bmark`;
        }
    }
}