/*
 * JBoss, Home of Professional Open Source
 * Copyright 2013, Red Hat, Inc. and/or its affiliates, and individual
 * contributors by the @authors tag. See the copyright.txt in the
 * distribution for a full listing of individual contributors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * http://www.apache.org/licenses/LICENSE-2.0
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.jboss.as.quickstarts.ejb_security_interceptors;

import org.jboss.as.core.security.RealmUser;

/**
 * A wrapper around the user for the Connection to act as a Credential.
 *
 * @author <a href="mailto:darran.lofthouse@jboss.com">Darran Lofthouse</a>
 */
public final class OuterUserCredential {

    private final RealmUser user;

    OuterUserCredential(final RealmUser user) {
        if (user == null) {
            throw new IllegalArgumentException("UserPrincipal can not be null.");
        }
        this.user = user;
    }

    String getName() {
        return user.getName();
    }

    String getRealm() {
        return user.getRealm();
    }

    @Override
    public int hashCode() {
        return user.hashCode();
    }

    @Override
    public boolean equals(Object other) {
        return other instanceof OuterUserCredential && equals((OuterUserCredential) other);
    }

    public boolean equals(OuterUserCredential other) {
        return this == other || other != null && user.equals(other.user);
    }

}
