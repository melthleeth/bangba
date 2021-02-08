const SERVER_URL = process.env.VUE_APP_SERVER_URL;

export default {
  
  async registerRecipe(context, payload) {
    console.log(context);
    console.log(payload);
    // const userId = context.rootGetters.userId;
    const recipeData = {
      user_no: context.rootGetters.pkUser,
      created_at: new Date().toLocaleTimeString(), // 변경 가능
      category: payload.category,
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

    // const token = context.rootGetters.token;
    const url = "http://localhost:8081/article/create";
    //axios의 then이 response.ok 다
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
    const responseData = await response.text(); //"
    console.log("responseData");
    console.log(responseData);

    //실패했을 때
    if (!response.ok) {
      // ...
    }
    context.commit("registerRecipe", recipeData);
  },




  //글을 불러오는 곳
  async loadBoard(context, payload) {
    
    if (!payload.forceRefresh && !context.getters.shouldUpdate) {
      console.log("if Check")
      return;
    }

    const page_num = 0;
    
    const url = `${SERVER_URL}/forum/search-forum-list/page=` + page_num;
    console.log(url);
    const response = await fetch(url, {
      headers: {
        "Content-Type": "application/json; charset=utf-8",
        'Accept': '*/*',
        'Access-Control-Allow-Origin': '*',
        'Access-Control-Allow-Headers': '*',
      },
      method: "GET",
    });
    console.log(response);
    const responseData = await response.json();

    console.log(responseData);
    // console.log(responseData);
    if (!response.ok) {
      console.log("error")
    }

    const boards = [];

    for (const key in responseData) {
      const board = {
        pk_forum: responseData[key].pk_forum,
        user_no: responseData[key].user_no,
        title: responseData[key].title,
        category: responseData[key].category,
        like_cnt: responseData[key].like_cnt,
        hits: responseData[key].hits,
        created_at: responseData[key].created_at,
        updated_at: responseData[key].updated_at,
        content:responseData[key].content,

      };
      boards.push(board);
    }
    context.commit("setBoards", boards);
  },
};
