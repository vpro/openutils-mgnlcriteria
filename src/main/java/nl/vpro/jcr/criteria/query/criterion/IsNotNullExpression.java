/*
 *
 * Criteria API for Magnolia CMS (http://www.openmindlab.com/lab/products/mgnlcriteria.html)
 * Copyright(C) 2009-2013, Openmind S.r.l. http://www.openmindonline.it
 *
 *  This program is free software: you can redistribute it and/or modify
 *  it under the terms of the GNU General Public License as published by
 *  the Free Software Foundation, either version 3 of the License, or
 *  (at your option) any later version.
 *
 *  This program is distributed in the hope that it will be useful,
 *  but WITHOUT ANY WARRANTY; without even the implied warranty of
 *  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *  GNU General Public License for more details.
 *
 *  You should have received a copy of the GNU General Public License
 *  along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

package nl.vpro.jcr.criteria.query.criterion;

import nl.vpro.jcr.criteria.query.Criteria;
import nl.vpro.jcr.criteria.query.JCRQueryException;
import nl.vpro.jcr.criteria.query.sql2.NotNullCondition;

/**
 * @author fgrilli
 */
public class IsNotNullExpression implements Criterion {

    private static final long serialVersionUID = 42L;

    private String nodeName;

    public IsNotNullExpression(String nodeName){
        this.nodeName = nodeName;
    }

    @Override
    public String toString() {
        return nodeName + " not null";
    }

    @Override
    public String toXPathString(Criteria criteria) throws JCRQueryException {
        return nodeName;
    }

    @Override
    public NotNullCondition toSQLCondition(Criteria criteria) {
        return new NotNullCondition(nodeName);
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        IsNotNullExpression that = (IsNotNullExpression) o;

        return nodeName != null ? nodeName.equals(that.nodeName) : that.nodeName == null;

    }

    @Override
    public int hashCode() {
        return nodeName != null ? nodeName.hashCode() : 0;
    }
}
