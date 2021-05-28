<template>
    <div class="row">
        <span>{{ projectName }}</span>
    </div>
</template>

<script>
export default {
    name: "AddProject",
    data(){
        return {
            projectId: null,
            timeId: null,
            projectName: "", 
            hours: 0, 
        }   
    }
}
</script>

<style>

</style>