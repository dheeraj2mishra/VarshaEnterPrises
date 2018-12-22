1. To Create Multimodule Maven Project
mvn archetype:generate -DgroupId=com.digital.education.system -DartifactId=digital-education-system-parent
change packing to pom and then go digital-education-system-parent folder and then execute below command
mvn archetype:generate -DgroupId=com.digital.education.system.common -DartifactId=digital-education-system-common
mvn archetype:generate -DgroupId=com.digital.education.system.data -DartifactId=digital-education-system-data
mvn archetype:generate -DgroupId=com.digital.education.system.service -DartifactId=digital-education-system-service
mvn archetype:generate -DgroupId=com.digital.education.system.ui -DartifactId=digital-education-system-ui -DarchetypeArtifactId=maven-archetype-webapp