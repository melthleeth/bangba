<template>
  <div>
    <span>{{ mode }}레시피 등록</span>
    <base-card>
      <form id="form-recipe" @submit.prevent="submitForm">
        <div class="form-control" :class="{ invalid: !img_path.isValid }">
          <label for="img_path">사진 등록</label>
          <img src="img_path.val" alt="cocktail image" />
          <base-button @click="showImgRegDialog">사진 등록</base-button>
          <p v-if="!img_path.isValid">등록된 사진이 없습니다.</p>
        </div>
        <div class="form-control" :class="{ invalid: !title_kor.isValid }">
          <label for="title_kor">칵테일 이름</label>
          <input
            type="text"
            id="title_kor"
            placeholder="칵테일 이름을 정해주세요"
            v-model.trim="title_kor.val"
            @blur="clearValidity('title_kor')"
          />
          <p v-if="!title_kor.isValid">칵테일 이름은 비어있으면 안됩니다.</p>
        </div>
        <div class="form-control" :class="{ invalid: !title_eng.isValid }">
          <label for="title_eng.val">칵테일 이름 (eng)</label>
          <input
            type="text"
            id="title_eng"
            placeholder="칵테일 영문명을 적어주세요"
            v-model.trim="title_eng.val"
            @blur="clearValidity('title_eng')"
          />
          <p v-if="!title_eng.isValid">칵테일 영문명은 비어있으면 안됩니다.</p>
        </div>
        <div class="form-control" :class="{ invalid: !content.isValid }">
          <label for="content">칵테일 소개</label>
          <input
            type="text"
            id="content"
            placeholder="어떤 칵테일인지 소개 해주세요"
            v-model.trim="content.val"
            @blur="clearValidity('content')"
          />
          <p v-if="!content.isValid">칵테일 소개는 비어있으면 안됩니다.</p>
        </div>
        <div class="form-control" :class="{ invalid: !tags.isValid }">
          <label for="tag">태그</label>
          <input type="text" id="tag" v-model.trim="tag.val" />
          <base-button @click="addTag">추가하기</base-button>
          <section>
            <!-- 중복 항목 검사 테스트 필요 -->
            <span class="mr-4" v-for="(index, tag) in tags" :key="tag">
              <span class="ml-2 text-grey-400" @click="removeTag(index)"
                >x</span
              >
            </span>
          </section>
          <p v-if="!tags.isValid">최소 하나의 태그를 추가해주세요.</p>
        </div>
        <div class="form-control" :class="{ invalid: !ingredients.isValid }">
          <label for="ingredients">재료 추가하기</label>
          <select name="type" id="type" v-model="type">
            <option value="">분류</option>
            <option value="type-alcohol">주류</option>
            <option value="type-ingredient">재료</option>
            <option value="type-garnish">가니쉬</option>
          </select>
          <input type="text" id="ingredient" v-model.trim="ingredient" />
          <input type="number" id="quantity" v-model.number="quantity" />
          <input type="text" id="unit" v-model.trim="unit" />
          <p v-if="!ingredients.isValid">최소 한 가지의 재료를 추가해주세요.</p>
        </div>
        <div class="form-control" :class="{ invalid: !recipes.isValid }">
          <label for="recipes">레시피 추가하기</label>
          <input type="text" id="recipe" v-model.trim="recipe" />
          <base-button @click="addIngredient">추가하기</base-button>
          <ul>
            <li
              v-for="(recipeItem, index) in recipes"
              :key="recipeItem"
              @click="removeRecipe(index)"
            >
              <span>{{ index }}. {{ recipeItem }}</span>
            </li>
          </ul>

          <p v-if="!recipes.isValid">최소 한 가지 순서를 추가해주세요.</p>
        </div>
        <p v-if="!formIsValid">
          비어있는 칸이 있습니다. 채운 후 다시 시도해주세요.
        </p>
        <base-button>레시피 등록하기</base-button>
      </form>
    </base-card>
  </div>
</template>

<script>
export default {
    props: {
        mode: {
            type: String,
            required: true,
            default: 'official'
        },
    },
    data() {
        return {
        formIsValid: true,
        isLoading: false,
        error: null,
        tag: '',
        type: '',
        ingredient: '',
        quantity: null,
        unit: '',
        recipe,
        img_path: {
            val: "../../assets/img/defaultCocktailImage.png",
            isValid: true,
        },
        title_kor: {
            val: "",
            isValid: true,
        },
        title_eng: {
            val: "",
            isValid: true,
        },
        content: {
            val: "",
            isValid: true,
        },
        tags: {
            val: [],
            isValid: true,
        },
        ingredients: {
            val: [],
            isValid: true,
        },
        recipes: {
            val: [],
            isValid: true,
        },
        };
  },
  methods: {
    showImgRegDialog() {
      console.log("사진 등록 중");
      alert("사진 등록 기능 준비중");
    },
    addTag() {
        if (this.tag.val !== "") {
      this.tags.push(this.tag);
      this.tag = "";
        } else alert("태그 내용을 입력해주세요.");
    },
    removeTag(index) {
      this.tags.splice(index, 1);
    },
    addIngredient() {
        if (this.type === "") {
            alert("분류를 선택해주세요.");
            return;
        }
        if (this.ingredient === "") {
            alert("재료명을 입력해주세요.");
            return;
        }
        if (!this.quantity || this.quantity < 0) {
            alert("용량을 입력해주세요.");
            return;
        }
        if(this.unit === "") {
            alert("단위를 입력해주세요.");
            return;
        }

        const ingredientItem = {
            type: this.type,
            ingredient: this.ingredient,
            quantity: this.quantity,
            unit: this.unit
        };

        this.ingredients.push(ingredientItem);
        alert("재료 (" + this.ingredient + ")가 추가되었습니다.");

        this.type = "";
        this.ingredient = "";
        this.quantity = null;
        this.unit = "";
    },
    removeIngredient(index) {
        this.ingredients.splice(index, 1);
    },
    addRecipe() {
      if (this.recipe !== "") {
        this.recipes.push(this.recipe);
        this.recipe = "";
      } else alert("레시피 내용을 입력해주세요.");
    },
    removeRecipe(index) {
      this.recipes.splice(index, 1);
    },
    clearValidity(input) {
      this[input].isValid = true;
    },
    validateForm() {
      if (this.title_kor.val === "") {
        this.title_kor.isValid = false;
        this.formIsValid = false;
      }
      if (this.title_eng.val === "") {
        this.title_eng.isValid = false;
        this.formIsValid = false;
      }
      if (this.content.val === "") {
        this.content.isValid = false;
        this.formIsValid = false;
      }
      if (this.tags.val.length === 0) {
        this.tags.isValid = false;
        this.formIsValid = false;
      }
      if (this.ingredients.val.length === 0) {
        this.ingredients.isValid = false;
        this.formIsValid = false;
      }
      if (this.recipes.val.length === 0) {
        this.recipes.isValid = false;
        this.formIsValid = false;
      }
    },
    submitForm() {
      this.validateForm();

      if (!this.formIsValid) return;

      const formData = {
        category: this.mode,
        img_path: this.img_path.val,
        title_kor: this.title_kor.val,
        title_eng: this.title_eng.val,
        content: this.content.val,
        tags: this.tags.val,
        ingredients: this.ingredients.val,
        recipes: this.recipes.val,
      };


        await this.$store.dispatch('registerRecipe', formData);
        this.$router.replace('/recipe/'+ this.mode);
    },
  },
};
/*
{
    "user_no": "user_no", // 얜 현재 로그인 된 유저 정보를 local storage에서 가져오는 방식으로 해야 할듯
    "title_kor": "title_kor",
    "title_eng": "title_eng",
    "created_at": "created_at", // 글 작성 날짜
    "content": "content",
    "img_path": "img_path",
    "category": "admin/user", // official인지 custom인지
    "abv": "abv", // 입력한 도수
    "cup_no": "cup_no",
    "alcohol": "alcohol1",
    "quantity": "quantity1",
    "unit": "unit1",
    "alcohol": "alcohol2",
    "quantity": "quantity2",
    "unit": "unit2",
    ...
    "ingredient": "ingredient1",
    "type": "type1",
    "quantity": "quantity1",
    "unit": "unit1",
    "ingredient": "ingredient2",
    "type": "type2",
    "quantity": "quantity2",
    "unit": "unit2",
    ...
    "tag": "tag1",
    "tag": "tag2",
    "tag": "tag3",
    "tag": "tag4",
    ...
    "recipe": "recipe1",
    "recipe": "recipe2",
    "recipe": "recipe3",
    ...

}
*/
</script>

<style scoped>
#form-recipe input {
  padding: 0.5rem 1rem;
  border: 1px solid #ccc;
  border-radius: 1rem;
}

#form-recipe input:focus {
  outline: none;
  border-color: #1b995e;
  background-color: #d7fdeb;
}

.invalid label {
  color: red;
}

.invalid input,
.invalid select {
  border: 1px solid red;
}
</style>
