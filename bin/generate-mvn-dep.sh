mvn install:install-file \
	-DgroupId=com.racoonberus.hotelHero \
	-DartifactId=hotelHeroOld \
	-Dversion=1.0 \
	-Dfile=target/hotel-hero.jar \
	-Dpackaging=jar \
	-DgeneratePom=true \
	-DlocalRepositoryPath=. \
	-DcreateChecksum=true
