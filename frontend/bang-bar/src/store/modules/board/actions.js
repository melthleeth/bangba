export default {
  async registerRecipe(context, payload) {
    console.log(context);
    console.log(payload);
  
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
    const url = 'http://localhost:8081/article/create';
    const response = await fetch(
      url,
      {
        headers: {
          "Content-Type": "application/json; charset=utf-8",
          'Accept': 'application/json;',
          'Access-Control-Allow-Origin': '*',
          'Access-Control-Allow-Headers': '*',
        },
        method: "POST",
        body: JSON.stringify(recipeData),
      }
    );
    const responseData = await response;
    console.log("responseData")
    console.log(responseData);

    if (!response.ok) {
      // ...
    }
    context.commit("registerRecipe", recipeData);
  },
  async loadRecipe(context, payload) {
    console.log("context: " + context);
    console.log("payload: " + payload);
  },
};
