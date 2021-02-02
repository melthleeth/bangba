export default {
  async registerRecipe(context, data) {
    console.log("context: " + context);
    console.log("data: " + data);

    // userId로 등록
    const userId = context.rootGetters.userId;
    const recipeData = {
      userId: userId,
      category: this.mode,
      img_path: this.img_path.val,
      title_kor: this.title_kor.val,
      title_eng: this.title_eng.val,
      content: this.content.val,
      tags: this.tags.val,
      ingredients: this.ingredients.val,
      recipes: this.recipes.val,
    };

    const token = context.rootGetters.token;
    const response = await fetch(
      `https://vue-http-demo-b9415-default-rtdb.firebaseio.com/recipes/${userId}.json?auth=${token}`,
      {
          method: 'PUT',
          body: JSON.stringify(recipeData),
      }
    );

    if (!response.ok) {
        // ...
    }   

    context.commit('registerRecipe', {
        ...recipeData,
        id: userId,
    });
  },
  async loadRecipe(context, payload) {
    console.log("context: " + context);
    console.log("payload: " + payload);
  },
};
