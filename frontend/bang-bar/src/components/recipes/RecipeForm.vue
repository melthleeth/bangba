<template>
  <form @submit.prevent="submitForm">
    <div class="form-control" :class="{ invalid: !img_path.isValid }">
      <label for="img_path">사진 등록</label>
      <img src="../../assets/img/defaultCocktailImage.png">
      <base-button @click="showImgRegDialog">사진 등록</base-button>
    </div>
    <div class="form-control" :class="{ invalid: !title_kor.isValid }">
      <label for="title_kor">칵테일 이름</label>
      <input
        type="text"
        id="title_kor"
        placeholder="칵테일 이름을 정해주세요"
        v-model.trim="title_kor"
        @blur="clearValidity('title_kor')"
      />
      <p v-if="!title_kor.isValid">칵테일 이름은 비어있으면 안됩니다.</p>
    </div>
    <div class="form-control" :class="{ invalid: !title_eng.isValid }">
      <label for="title_eng">칵테일 이름 (eng)</label>
      <input
        type="text"
        id="title_eng"
        placeholder="칵테일 영문명을 적어주세요"
        v-model.trim="title_eng"
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
        v-model.trim="content"
        @blur="clearValidity('')"
      />
      <p v-if="!content.isValid">칵테일 소개는 비어있으면 안됩니다.</p>
    </div>
    <div class="form-control" :class="{ invalid: !tag.isValid }">
      <label for="tag">태그</label>
      <input
        type="text"
        id="tag"
        v-model.trim="tag"
        @blur="clearValidity('tag')"
      />
      <base-button @click="">추가하기</base-button>
      <p v-if="!tag.isValid">태그는 비어있으면 안됩니다.</p>
    </div>
    <div class="form-control" :class="{ invalid: !ingredient.isValid }">
      <label for="ingredient"></label>
      <input
        type="text"
        id="ingredient"
        v-model.trim="ingredient"
        @blur="clearValidity('ingredient')"
      />
      <p v-if="!ingredient.isValid">재료는 비어있으면 안됩니다.</p>
    </div>
    <div class="form-control" :class="{ invalid: !recipe.isValid }">
      <label for="recipe"></label>
      <input
        type="text"
        id="recipe"
        v-model.trim="recipe"
        @blur="clearValidity('recipe')"
      />
      <p v-if="!recipe.isValid">재료는 비어있으면 안됩니다.</p>
    </div>
    <p v-if="!formIsValid">비어있는 칸이 있습니다. 채운 후 다시 시도해주세요.</p>
    <base-button>레시피 등록하기</base-button>
  </form>
</template>

<script>
export default {
    data() {
        return {
            formIsValid: true,
            isLoading: false,
            error: null,
            img_path: {
                val: '',
                isValid: true,
            },
            title_kor: {
                val: '',
                isValid: true,
            },
            title_eng: {
                val: '',
                isValid: true,
            },
            content: {
                val: '',
                isValid: true,
            },
            tag: {
                val: '',
                isValid: true,
            },
            ingredient: {
                val: '',
                isValid: true,
            },
            recipe: {
                val: '',
                isValid: true,
            },
        };
    },
    methods: {
        showImgRegDialog() {
            console.log("사진 등록 중");
        },
        clearValidity(input) {
            this[input].isValid = true;
        },
        validateForm() {
            if (this.title_kor.isValid === '') {
                this.title_kor.isValid = false;
                this.formIsValid = false;
            }
            if (this.title_eng.isValid === '') {
                this.title_eng.isValid = false;
                this.formIsValid = false;
            }
            if (this.content.isValid === '') {
                this.content.isValid = false;
                this.formIsValid = false;
            }
            if (this.tag.isValid === '') {
                this.tag.isValid = false;
                this.formIsValid = false;
            }
            if (this.ingredient.isValid === '') {
                this.ingredient.isValid = false;
                this.formIsValid = false;
            }
            if (this.recipe.isValid === '') {
                this.recipe.isValid = false;
                this.formIsValid = false;
            }
        },
        submitForm() {
            this.validateForm();

            if (!this.formIsValid) return;



            const formData = {

            }
        }
    }
}
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
