package nl.vpro.jcr.criteria.query.sql2;


import lombok.AllArgsConstructor;
import lombok.Data;

import javax.annotation.Nonnull;

import nl.vpro.jcr.criteria.query.criterion.Criterion;

/**
 * @author Michiel Meeuwissen
 * @since 2.0
 */
@AllArgsConstructor
@Data
public class IsDescendantNode implements Condition {

    @Nonnull
    final String path;

    @Override
    public boolean toSql2(StringBuilder builder) {
        if (! "/".equals(path) && ! Criterion.ALL_ELEMENTS.equals(path)) {
            builder.append("ISDESCENDANTNODE(a, '").append(path).append("')");
            return true;
        }
        return false;
    }
}
