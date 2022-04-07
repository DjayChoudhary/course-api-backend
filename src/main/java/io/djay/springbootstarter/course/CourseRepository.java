package io.djay.springbootstarter.course;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

// A Dataservice in which one can do crud operations
// Spring Data JPA implements this interface
// Spring Data JPA has common crud methods for any entity
// CrudRepository<EntityClass, Id or Primary Key OfEntityClass>
public interface CourseRepository extends CrudRepository<Course, String> {

	// getAllTopics()
	// getTopic(String id)
	// updateTopic(Topic topic)
	// deleteTopic(String id)

	
	public List<Course> findByTopicId(String topicId);

}
