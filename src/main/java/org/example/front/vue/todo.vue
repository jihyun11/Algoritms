<template>
  <form @submit.prevent="addTodo">
    <input v-model="newTodo">
    <button>할 일 추가</button>
  </form>
  <ul>
    <li v-for="todo in todos">
      {{ todo.issue }} - <button @click="removeTodo(todo)">Done</button>
    </li>
  </ul>
</template>

<script>
export default {
  name: "todo.vue"
}

const newTodo = ref('')
const todos = ref([
  { id: id++, issue: 'Backlog' }, { id: id++, issue: 'Todo' },
  { id: id++, issue: 'Going Hawaii' }
])
function addTodo(){
  console.log(newTodo.value)
  todos.value.push({ id: id++, issue: newTodo.value })
  newTodo.value = ''
}
function removeTodo(todo){
  console.log(todo)
  todos.value = todos.value.filter((t) => t !== todo)
}


</script>

<style scoped>

</style>