const SERVER_URL = process.env.VUE_APP_SERVER_URL;
export default {
  async registerRecipe(context, payload) {
    console.log(context);
    console.log(payload);

    let isOfficial = true;
    if (payload.category === "custom") {
      isOfficial = false;
    }
    const recipeData = {
      user_no: context.rootGetters.pkUser,
      created_at: new Date().toLocaleTimeString(), // 변경 가능
      category: isOfficial,
      img_path: payload.img_path,
      title_kor: payload.title_kor,
      title_eng: payload.title_eng,
      abv: payload.abv,
      content: payload.content,
      cup_no: payload.cupinfo,
      tag: payload.tags,
      alcohol: payload.alcohols,
      ingredient: payload.ingredients,
      recipe: payload.recipes,
    };
    console.log(recipeData);
    const url = `${SERVER_URL}/article/create`;
    const response = await fetch(url, {
      headers: {
        "Content-Type": "application/json; charset=utf-8",
        'Accept': '*/*',
        'Access-Control-Allow-Origin': '*',
        'Access-Control-Allow-Headers': '*',
      },
      method: "POST",
      body: JSON.stringify(recipeData),
    });
    const responseData = await response.text();
    console.log("responseData");
    console.log(responseData);

    if (responseData === "error") {
      // ...
    }
    alert("등록이 완료되었습니다.");
  },

  //글을 불러오는 것
  async loadRecipes(context, payload) {
    if (!payload.forceRefresh && !context.getters.shouldUpdate) {
      return;
    }

    const keyword = {
      searchtxt: "",
      tag: ""
    };

    const response = await fetch(`${SERVER_URL}/article/all`, {
      headers: {
        "Content-Type": "application/json; charset=utf-8",
        Accept: "application/json;",
        "Access-Control-Allow-Origin": "*",
        "Access-Control-Allow-Headers": "*",
      },
      method: "POST",
      body: JSON.stringify(keyword),
    });
    const responseData = await response.json();
    // console.log(responseData);
    if (!response.ok) {
      // error..
    }

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

    context.commit("setRecipes", recipes);
    context.commit("setFetchTimestamp");
  },
};
