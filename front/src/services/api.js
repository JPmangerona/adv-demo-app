import axios from 'axios';

const apiInstance = axios.create({
  baseURL: '/api',
  headers: {
    'Content-Type': 'application/json'
  }
});

// Generic CRUD factory
const createCrudEndpoints = (baseRoute) => ({
  getAll: () => apiInstance.get(`/${baseRoute}`),
  getById: (id) => apiInstance.get(`/${baseRoute}/${String(id)}`),
  create: (data) => apiInstance.post(`/${baseRoute}`, data),
  update: (id, data) => apiInstance.put(`/${baseRoute}/${String(id)}`, data),
  delete: (id) => apiInstance.delete(`/${baseRoute}/${String(id)}`)
});

export const api = {
  instance: apiInstance,
  advogados: {
    getAll: () => apiInstance.get('/advogados'),
    create: (data) => apiInstance.post('/advogados', data),
    update: (id, data) => apiInstance.put(`/advogados/${String(id)}`, data),
    delete: (id) => apiInstance.delete(`/advogados/${String(id)}`)
    // Missing getById in specs: GET /advogados/{id} was not explicitly provided but we stick to the ones that were
  },
  assistentes: createCrudEndpoints('assistentes'),
  clientes: createCrudEndpoints('clientes'),
  processos: createCrudEndpoints('processos'),
  usuarios: {
    create: (data) => apiInstance.post('/usuarios', data)
  }
};

export default api;
