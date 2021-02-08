<template>
    <div class="h-screen text-center bg-white mx-24 my-12">
    <span class="text-4xl font-bold">팔로잉/팔로워</span>
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
div {
    border-radius: 45px;
}
</style> 