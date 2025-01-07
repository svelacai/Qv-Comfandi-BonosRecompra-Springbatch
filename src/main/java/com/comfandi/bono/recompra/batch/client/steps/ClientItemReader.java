package com.comfandi.bono.recompra.batch.client.steps;

//public class ClientItemReader {
//
//    private static final String ACTIVE_STATE = "Active";
//    private static final char CATEGORY_C = 'C';
//    private static final String QUERY = "SELECT c FROM Client c WHERE c.state = :state AND c.clientCategory != :category";
//    private static final int PAGE_SIZE = 10;
//
//    @Bean
//    public JpaPagingItemReader<Client> clienteItemReader(@Autowired EntityManagerFactory entityManagerFactory) {
//        JpaPagingItemReader<Client> reader = new JpaPagingItemReader<>();
//        
//        reader.setEntityManagerFactory(entityManagerFactory);
//        reader.setQueryString(QUERY);
//        
//        // Definir parámetros de manera más limpia
//        Map<String, Object> parameterValues = new HashMap<>();
//        parameterValues.put("state", ACTIVE_STATE);
//        parameterValues.put("category", CATEGORY_C);
//        reader.setParameterValues(parameterValues);
//
//        reader.setPageSize(PAGE_SIZE); // El tamaño de la página
//
//        return reader;
//    }
//}
