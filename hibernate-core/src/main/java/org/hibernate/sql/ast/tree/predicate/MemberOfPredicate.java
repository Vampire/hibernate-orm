/*
 * Hibernate, Relational Persistence for Idiomatic Java
 *
 * License: GNU Lesser General Public License (LGPL), version 2.1 or later
 * See the lgpl.txt file in the root directory or http://www.gnu.org/licenses/lgpl-2.1.html
 */
package org.hibernate.sql.ast.tree.predicate;

import org.hibernate.sql.ast.SqlAstWalker;
import org.hibernate.sql.ast.tree.expression.Expression;
import org.hibernate.sql.ast.tree.select.QuerySpec;

/**
 * @author Andrea Boriero
 */
public class MemberOfPredicate implements Predicate {
	private final Expression leftHandExpression;
	private final QuerySpec querySpec;
	private final boolean isNegated;

	public MemberOfPredicate(
			Expression leftHandExpression,
			boolean isNegated,
			QuerySpec querySpec) {
		this.leftHandExpression = leftHandExpression;
		this.isNegated = isNegated;
		this.querySpec = querySpec;
	}

	@Override
	public boolean isEmpty() {
		return false;
	}

	@Override
	public void accept(SqlAstWalker sqlTreeWalker) {
		sqlTreeWalker.visitMemberOfPredicate( this );
	}

	public boolean isNegated() {
		return isNegated;
	}

	public Expression getLeftHandExpression() {
		return leftHandExpression;
	}

	public QuerySpec getQuerySpec() {
		return querySpec;
	}
}