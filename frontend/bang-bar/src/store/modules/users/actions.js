const SERVER_URL = process.env.VUE_APP_SERVER_URL;
export default {
    // 내가 쓴 글 불러오기
    async LoadMyRecipe(context) {
        const response = await fetch(`${SERVER_URL}/user/mypage/article/` + context.rootGetters.pkUser, {
            headers: {
                "Content-Type": "application/json; charset=utf-8",
                'Accept': '*/*',
                'Access-Control-Allow-Origin': '*',
                'Access-Control-Allow-Headers': '*',
            },
            method: "GET",
        });
        const responseData = await response.json();
        const recipes = [];

        for (const key in responseData) {
            const recipe = {
                pk_article: responseData[key].pk_article,
                user_name: responseData[key].user_name,
                title_kor: responseData[key].title_kor,
                title_eng: responseData[key].title_eng,
                like_cnt: responseData[key].like_cnt,
                bookmark_cnt: responseData[key].bookmark_cnt,
                hits: responseData[key].hits,
                created_at: responseData[key].created_at,
                updated_at: responseData[key].updated_at,
                like_weekly: responseData[key].like_weekly,
                content: responseData[key].content,
                img_path: responseData[key].img_path,
                category: responseData[key].category,
                abv: responseData[key].abv,
                cup_no: responseData[key].cup_no,
                tag: responseData[key].tag,
                alcohol: responseData[key].alcohol,
                ingredient: responseData[key].ingredient,
                recipe: responseData[key].recipe,
            };
            recipes.push(recipe);
        }
        context.commit("setMyRecipe", recipes);
    },
    // 닉네임 중복확인 
    async checkName(_, payload) {
        console.log(payload);
        const response = await fetch(`${SERVER_URL}/user/join/${payload}`, {
            headers: {
                "Content-Type": "application/json; charset=utf-8",
                'Accept': '*/*',
                'Access-Control-Allow-Origin': '*',
                'Access-Control-Allow-Headers': '*',
              },
              method: "POST"
        });

        const responseData = await response.text();
        
        if(responseData === "FAIL") {
            alert("중복된 닉네임입니다.");
        } else {
            alert("사용가능한 닉네임입니다.");
        }
    }
};