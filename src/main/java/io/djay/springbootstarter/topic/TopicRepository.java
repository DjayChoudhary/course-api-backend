package io.djay.springbootstarter.topic;

import org.springframework.data.repository.CrudRepository;

// A Dataservice in which one can do crud operations
// Spring Data JPA implements this interface
// Spring Data JPA has common crud methods for any entity
// CrudRepository<EntityClass, Id or Primary Key OfEntityClass>
public interface TopicRepository extends CrudRepository<Topic, String>{ 
	
	// getAllTopics()
	// getTopic(String id)
	// updateTopic(Topic topic)
	// deleteTopic(String id)
	
	

}
