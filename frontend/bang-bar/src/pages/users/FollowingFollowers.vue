<template>
  <div class="flex flex-col font-S-CoreDream-light font-color-black-400 w-max">
    <span
      class="tracking-wider font-semibold text-2xl border-gray-800 border-b-4 font-S-CoreDream-medium w-max px-1 mt-10"
      >팔로잉/팔로워</span
    >
    <div class="flex grid grid-cols-3 grid-flow-row gap-4"></div>
  </div>
</template>

<script>
// const SERVER_URL = process.env.VUE_APP_SERVER_URL;

export default {
    data() {
        return {
            target_no:"",
            user_no:localStorage.getItem("pk_user")
        }
    }, 
    methods: {

    }
}
</script>

<style scoped>

</style> 