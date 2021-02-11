<template>
  <div class="flex flex-col font-S-CoreDream-light font-color-black-400 w-max">
    <span
      class="tracking-wider font-semibold text-2xl border-gray-800 border-b-4 font-S-CoreDream-medium w-max px-1 mt-10"
      >프로필 변경</span
    >
    <section class="flex">
      <article
        class="flex flex-col mt-6 ml-4 mr-10 justify-items-center content-center"
      >
        <img
          id="profileImage"
          alt="profile image"
          :src="imgsrc"
          class="h-24 w-24 mx-auto mb-3 cursor-pointer rounded-full object-cover text-center"
        />
        <!-- <base-button class="btn px-3 py-1 mr-0 text-sm"  @click="changeProfileImage"
          >이미지 변경</base-button
        > -->

        <label class="btn px-3 py-1 text-sm"
          >이미지 변경
          <input
            type="file"
            class="hidden"
            id="image_uploads"
            name="image_uploads"
            accept=".jpg, .jpeg, .png .gif"
            @change="changeProfileImage"
          />
        </label>
      </article>
      <article class="my-auto flex flex-col">
        <div class="items-center">
          <input
            class="text-base text-left rounded-full px-8 py-3 mr-4 hover:bg-gray-100 focus:outline-none"
            id="username"
            type="text"
            placeholder="닉네임"
            v-model="user_name"
          />
          <base-button
            mode="important"
            class="px-6 py-3 text-sm"
            @click="checkDuplication"
            >중복 확인</base-button
          >
        </div>
        <div class="text-xs font-color-black-200 mt-2">
          <p>* 이름은 최소 2자, 최대 10자까지 입력이 가능해요</p>
          <p>* 수정한 정보는 방구석 바텐더의 서비스에 바로 적용돼요</p>
        </div>
      </article>
    </section>
      <article class="flex justify-self-center mx-auto mt-10">
      <base-button class="px-4 py-2 text-sm">변경사항 저장하기</base-button>
    </article>
    <span
      class="tracking-wider font-semibold text-2xl border-gray-800 border-b-4 font-S-CoreDream-medium w-max px-1 mt-12"
      >개인정보 변경</span
    >
    <section class="flex">
      <article class="m-4 mt-6 flex flex-col">
        <span class="font-S-CoreDream-medium text-right mr-10 mb-10"
          >이메일</span
        >
        <span class="font-S-CoreDream-medium text-right mr-10">비밀번호</span>
      </article>
      <article class="m-4 mt-6 flex flex-col">
        <span class="font-S-CoreDream-medium mb-10">{{ user_id }}</span>
        <input
          class="text-sm text-left rounded-full px-8 py-3 mb-4 border-3 border-transparent hover:bg-gray-100 focus:outline-none"
          id="currentPassword"
          type="text"
          placeholder="현재 비밀번호"
        />
        <input
          class="text-sm text-left rounded-full px-8 py-3 mb-4 border-3 border-transparent hover:bg-gray-100 focus:outline-none"
          id="newPassword"
          type="text"
          placeholder="새 비밀번호"
        />
        <input
          class="text-sm text-left rounded-full px-8 py-3 mb-4 border-3 border-transparent hover:bg-gray-100 focus:outline-none"
          id="confirmNewPassword"
          type="text"
          placeholder="새 비밀번호 확인"
        />
      </article>
    </section>
    <article class="flex justify-self-center mx-auto mt-10">
      <base-button class="px-4 py-2 text-sm">변경사항 저장하기</base-button>
    </article>
  </div>
</template>

<script>
export default {
  data() {
    return {
      user_id: "test@test.com",
      user_name: "미스터 여우씨",
      imgsrc:
        "https://www.lifewire.com/thmb/wTQhx22YA7ljA0-dTNKiHp2bReI=/1142x642/smart/filters:no_upscale()/iphonex_animoji_fox-59dd137c03f4020010a60b54.gif",
    };
  },
  methods: {
    changeProfileImage(input) {
      // alert("프로필 사진 변경");
      console.log(input.target.files[0].name);
      const objectURL = URL.createObjectURL(input.target.files[0]);
      this.imgsrc = objectURL;
    },
    checkDuplication() {
      alert("닉네임 중복 확인");
    },
  },
};
</script>

<style scoped>
.btn {
  background-color: #00002f;
  border: 3px solid #00002f;
  color: white;
  cursor: pointer;
  border-radius: 30px;
  display: inline-block;
  transition: 0.3s ease-out;
}

.btn:hover {
  color: #FF5E46;
}
</style>
