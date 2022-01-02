# SpringBoot-Security-Kotlin

프로젝트 생성시 

java 11 , SpringBoot 2.6.2 , jar-gradle 


기본환경 

mariadb 



공부 내용) 

권한 여러개 설정시 

interface UserDetails를 implements할때  getAuthorities에 권한리스트를 반환시키면됨 

-> Collection<UserRoles> 속성으로 가지고, 해당 리스트를 반환 
