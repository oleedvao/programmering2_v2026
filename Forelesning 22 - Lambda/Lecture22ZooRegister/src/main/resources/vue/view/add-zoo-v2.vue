<template id="add-zoo-template">
  <h1>Add Zoo</h1>
  <form @submit.prevent="submitForm">
    <label for="name">Name:</label><br>
    <input type="text" id="name" v-model="zooName"><br>
    <input type="submit" value="Create">
  </form>
</template>

<script>
app.component("add-zoo-v2", {
  template: "#add-zoo-template",
  data() {
    return {
      zooName: ""
    }
  },
  methods: {
    async submitForm() {
      const params = new URLSearchParams();
      params.append("zoo-name", this.zooName)

      try {
        const response = await fetch("/api/add-zoo", {
          method: "POST",
          body: params
        });

        if (response.ok) {
          window.location.href = "/all-zoos";
        }
      } catch (error) {
        console.error("Submission failed", error)
      }
    }
  }
})
</script>