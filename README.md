# COVID-19 Alert Microservice with Spring Boot
A  Spring Boot microservice  to provide alerts based on location.


# Data source
The main source API for this implementation will be https://covid19tracking.narrativa.com/index_en.html  
Documentation is available at https://documenter.getpostman.com/view/10831675/SzYZ1eNY#9741ae31-6493-4d32-aec3-a272e4bcec67   
## API use example
```bash 
https://api.covid19tracking.narrativa.com/api/2020-11-07/country/egypt/region/cairo
```

# Basic Microservice Architecture
I have modified the architecture from the original author to work with any country and region.  
However, this provides a basic overview of the microservice.
![img.png](microserviceArchitecture-GreenLearner.png)
