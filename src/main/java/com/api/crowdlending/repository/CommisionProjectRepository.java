package com.api.crowdlending.repository;



	import javax.persistence.Table;

    import org.springframework.data.jpa.repository.JpaRepository;
    import org.springframework.data.jpa.repository.Query;
	import org.springframework.stereotype.Repository;

	import com.api.crowdlending.model.*;



	import java.util.List;

	@Repository
	@Table(name = "list_commission_project")
	public interface CommisionProjectRepository extends JpaRepository<CommissionProjectModel, Long> {


		 @Query(value = "SELECT  *  FROM  list_commission_project   WHERE   token_project=?1", nativeQuery = true)
		 List<CommissionProjectModel>  findCheckCommissionProject(String tokenProject);



	}
