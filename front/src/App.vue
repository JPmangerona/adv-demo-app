<template>
  <div style="width: 100%; min-height: 100vh; display: flex; flex-direction: row;">
    <TheSidebar v-if="$route.path !== '/' && $route.path !== '/register'" :isOpen="isSidebarOpen" />
    <main style="flex: 1; overflow-y: auto; background-color: #f8fafc; display: flex; flex-direction: column;">
      <!-- Topbar for toggle -->
      <div v-if="$route.path !== '/' && $route.path !== '/register'" class="w-full bg-white shadow-sm p-4 flex items-center">
        <button @click="toggleSidebar" class="p-2 rounded-lg hover:bg-slate-100 text-slate-600 transition-colors flex items-center justify-center">
          <span class="material-symbols-outlined text-2xl">menu</span>
        </button>
      </div>
      
      <!-- Main Content -->
      <div class="flex-1">
        <router-view></router-view>
      </div>
    </main>
  </div>
</template>

<script>
import TheSidebar from './components/TheSidebar.vue'

export default {
  name: 'App',
  components: {
    TheSidebar
  },
  data() {
    return {
      isSidebarOpen: true
    }
  },
  methods: {
    toggleSidebar() {
      this.isSidebarOpen = !this.isSidebarOpen;
    }
  }
}
</script>

<style scoped>
</style>
