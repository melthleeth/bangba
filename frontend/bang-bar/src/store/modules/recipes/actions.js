const SERVER_URL = process.env.VUE_APP_SERVER_URL;
export default {
  async registerRecipe(context, payload) {
    console.log(context);
    console.log(payload);

    /*
    {
    "user_no": "1", 
    "title_kor": "title_kor",
    "title_eng": "title_eng",
    "created_at": "202102021447", 
    "content": "content",
    "img_path": "img_path2",
    "category": "admin",
    "abv": "16", 
    "cup_no": "1",
    "alcohol": "그레이 구스/15/ml,진/15/ml,스미노프 No.21/15/ml,데킬라/15/ml,Kahlúa/15/ml",
    "ingredient": "재료/레몬 주스/25/ml,재료/토닉 워터/30/ml,재료/콜라/1/캔,가니쉬/레몬/1/개",
    "tag": "데킬라,보드카,레몬,맛있는",
    "recipe": "recipe1,recipe2,recipe3"
  }
    */
    // const userId = context.rootGetters.userId;
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
    // const token = context.rootGetters.token;
    const url = `${SERVER_URL}/article/create`;
    const response = await fetch(url, {
      headers: {
        "Content-Type": "application/json; charset=utf-8",
        Accept: "application/json;",
        "Access-Control-Allow-Origin": "*",
        "Access-Control-Allow-Headers": "*",
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
    // context.commit("registerRecipe", recipeData);
  },
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
