<template>
  <div class="p-8 bg-[#f8fafd] min-h-screen">
    <div class="mb-10">
      <h2 class="text-3xl font-bold text-slate-900">Bom dia, Dr. Ricardo</h2>
      <p class="text-slate-500 mt-1">Sua produtividade aumentou 15% em relação à semana passada.</p>
    </div>

    <div class="grid grid-cols-1 md:grid-cols-2 xl:grid-cols-4 gap-6 mb-10">
      <div class="stat-card">
       
        <div class="mt-4">
          <p class="text-slate-500 text-sm font-bold uppercase">Processos Ativos</p>
          <p class="text-4xl font-extrabold text-slate-900">142</p>
        </div>
      </div>

      <div class="stat-card">
        <div class="mt-4">
          <p class="text-slate-500 text-sm font-bold uppercase">Prazos Pendentes</p>
          <p class="text-4xl font-extrabold text-slate-900">12</p>
        </div>
      </div>

      <div class="stat-card">
        <div class="mt-4">
          <p class="text-slate-500 text-sm font-bold uppercase">Audiências Hoje</p>
          <p class="text-4xl font-extrabold text-slate-900">05</p>
        </div>
      </div>

      <div class="stat-card bg-gradient-to-br from-blue-900 to-indigo-900 text-white">
        <span class="material-symbols-outlined text-white bg-white/20 p-3 rounded-xl">payments</span>
        <div class="mt-4">
          <p class="text-blue-200 text-sm font-bold uppercase">Faturamento Mês</p>
          <p class="text-4xl font-extrabold">R$ 42k</p>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
export default {
  name: 'DashboardView'
}
</script>

<style scoped>
.stat-card {
  background: white;
  padding: 24px;
  border-radius: 16px;
  border: 1px solid #e2e8f0;
  box-shadow: 0 1px 3px rgba(0,0,0,0.05);
}
</style>