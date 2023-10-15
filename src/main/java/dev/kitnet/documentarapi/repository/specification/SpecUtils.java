package dev.kitnet.documentarapi.repository.specification;

import dev.kitnet.documentarapi.utils.StringUtils;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.Expression;
import jakarta.persistence.criteria.Predicate;

public class SpecUtils {

    public static Predicate textPredicate(Expression<String> path, String value, CriteriaBuilder criteriaBuilder) {
        return criteriaBuilder.like(
                criteriaBuilder.function(
                        "unaccent",
                        String.class,
                        criteriaBuilder.upper(path)
                ),
                "%" + StringUtils.unaccent(value.toUpperCase()) + "%"
        );
    }
}
