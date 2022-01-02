# SpringBoot-Security-Kotlin

1. 프로젝트 생성시 

java 11 , SpringBoot 2.6.2 , jar-gradle 



2. 기본환경 

mariadb 





3. 잘 안됐던 내용 참고 

권한 여러개 설정시 

interface UserDetails를 implements할때  getAuthorities에 권한리스트를 반환시키면됨 


->  이때 리스트를 getAuthorities에 동적으로 넣어주면 안돼서 ,   "Collection<UserRoles> 속성"으로 가지고 해당값으로 반환함 
