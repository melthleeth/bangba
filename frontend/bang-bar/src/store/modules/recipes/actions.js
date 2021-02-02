export default {
  async registerRecipe(context, payload) {
    console.log("context: " + context);
    console.log("payload: " + payload);

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
    const userId = context.rootGetters.userId;
    const recipeData = {
      userId: userId,
      created_at: new Date().toLocaleTimeString(), // 변경 가능
      category: payload.mode,
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

    const token = context.rootGetters.token;
    const response = await fetch(
      `https://vue-http-demo-b9415-default-rtdb.firebaseio.com/recipes/${userId}.json?auth=${token}`,
      {
        method: "PUT",
        body: JSON.stringify(recipeData),
      }
    );

    if (!response.ok) {
      // ...
    }

    context.commit("registerRecipe", {
      ...recipeData,
      id: userId,
    });
  },
  async loadRecipe(context, payload) {
    console.log("context: " + context);
    console.log("payload: " + payload);
  },
};
