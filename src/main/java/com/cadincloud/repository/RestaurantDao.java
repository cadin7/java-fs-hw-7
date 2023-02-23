package com.cadincloud.repository;

import com.cadincloud.model.dto.RestaurantFilters;
import com.cadincloud.model.entity.RestaurantEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static java.util.Optional.ofNullable;

@Repository
public class RestaurantDao {
    private final EntityManager entityManager;
    private final CriteriaBuilder criteriaBuilder;
    private final RestaurantRepository repository;

    public RestaurantDao(EntityManager entityManager, RestaurantRepository repository) {
        this.entityManager = entityManager;
        this.criteriaBuilder = this.entityManager.getCriteriaBuilder();
        this.repository = repository;
    }

    public Optional<RestaurantEntity> getRestaurant(Long restaurantId) {
        return repository.findById(restaurantId);
    }

    public Page<RestaurantEntity> getRestaurants(RestaurantFilters filters, Pageable pageable) {
        final var criteria = criteriaBuilder.createQuery(RestaurantEntity.class);
        final var root = criteria.from(RestaurantEntity.class);
        final var query = criteria.select(root)
                .where(getWhereClause(filters, root).toArray(new Predicate[0]));

        final var totalRows = getTotalRows(filters);
        final var paginatedResultList = getPaginatedResultList(query, pageable);

        return new PageImpl<>(paginatedResultList, pageable, totalRows);
    }

    public RestaurantEntity saveRestaurant(RestaurantEntity newRestaurantEntity) {
        return repository.save(newRestaurantEntity);
    }

    private Long getTotalRows(RestaurantFilters filters) {
        final var cq = criteriaBuilder.createQuery(Long.class);
        final var root = cq.from(RestaurantEntity.class);
        cq.select(criteriaBuilder.count(root))
                .where(getWhereClause(filters, root).toArray(new Predicate[0]));

        return entityManager.createQuery(cq).getSingleResult();
    }

    public boolean existsByNameAndIdNot(RestaurantEntity restaurantEntity) {
        return repository.existsByNameAndIdNot(restaurantEntity.getName(), restaurantEntity.getId());
    }

    public void deleteRestaurant(Long restaurantId) {
        repository.deleteById(restaurantId);
    }

    private List<Predicate> getWhereClause(RestaurantFilters filters, Root<RestaurantEntity> root) {
        List<Predicate> whereClause = new ArrayList<>();

        ofNullable(filters.city())
                .ifPresent(city -> whereClause.add(criteriaBuilder.equal(root.get("city"), city)));
        ofNullable(filters.stars())
                .ifPresent(stars -> whereClause.add(criteriaBuilder.equal(root.get("stars"), stars)));

        return whereClause;
    }

    private List<RestaurantEntity> getPaginatedResultList(CriteriaQuery<RestaurantEntity> query, Pageable pageable) {
        return entityManager.createQuery(query)
                .setMaxResults(pageable.getPageSize())
                .setFirstResult(pageable.getPageNumber() * pageable.getPageSize())
                .getResultList();
    }
}
