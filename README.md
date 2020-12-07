# COVID-19 Alert Microservice with Spring Boot
A  Spring Boot microservice  to provide alerts based on location.

# Current Implementation
The current implementation allows providing a ```country``` name and a ```state``` name. The returned result, will be a measures recommendation based on the current number of new cases in that region.  
- Port: 9090
- Endpoint: ```/status/```
- Request: GET
- Path variables: ```/{country}/{state} ```  
####Usage example
http://localhost:9090/status/Germany/Berlin

# Data source
The main source API for this implementation will be https://covid19tracking.narrativa.com/index_en.html  
Documentation is available at https://documenter.getpostman.com/view/10831675/SzYZ1eNY#9741ae31-6493-4d32-aec3-a272e4bcec67     
## API use example
```bash 
https://api.covid19tracking.narrativa.com/api/2020-11-07/country/egypt/region/cairo
```

# Basic Microservice Architecture
// Digrame to be added! 
