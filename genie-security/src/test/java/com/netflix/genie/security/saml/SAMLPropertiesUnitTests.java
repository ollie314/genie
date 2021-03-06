/*
 *
 *  Copyright 2016 Netflix, Inc.
 *
 *     Licensed under the Apache License, Version 2.0 (the "License");
 *     you may not use this file except in compliance with the License.
 *     You may obtain a copy of the License at
 *
 *         http://www.apache.org/licenses/LICENSE-2.0
 *
 *     Unless required by applicable law or agreed to in writing, software
 *     distributed under the License is distributed on an "AS IS" BASIS,
 *     WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *     See the License for the specific language governing permissions and
 *     limitations under the License.
 *
 */
package com.netflix.genie.security.saml;

import com.netflix.genie.test.categories.UnitTest;
import org.hamcrest.Matchers;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.experimental.categories.Category;

import java.util.UUID;

/**
 * Tests for SAMLProperties.
 *
 * @author tgianos
 * @since 3.0.0
 */
@Category(UnitTest.class)
public class SAMLPropertiesUnitTests {

    private static final String USER_NAME = UUID.randomUUID().toString();
    private static final String GROUPS_NAME = UUID.randomUUID().toString();
    private static final String GROUPS_ADMIN = UUID.randomUUID().toString();
    private static final String IDP_SERVICE_PROVIDER_METADATA_URL = UUID.randomUUID().toString();
    private static final String KEYSTORE_NAME = UUID.randomUUID().toString();
    private static final String KEYSTORE_PASSWORD = UUID.randomUUID().toString();
    private static final String DEFAULT_KEY_NAME = UUID.randomUUID().toString();
    private static final String DEFAULT_KEY_PASSWORD = UUID.randomUUID().toString();
    private static final String SP_ENTITY_ID = UUID.randomUUID().toString();
    private static final String SP_ENTITY_BASE_URL = UUID.randomUUID().toString();

    private SAMLProperties properties;

    /**
     * Setup for tests.
     */
    @Before
    public void setup() {
        this.properties = new SAMLProperties();
    }

    /**
     * Test to make sure the setters and getters are all correct even generated by Lombok.
     */
    @Test
    public void canSetGetAll() {
        final SAMLProperties.Attributes.User user = new SAMLProperties.Attributes.User();
        user.setName(USER_NAME);
        final SAMLProperties.Attributes.Groups groups = new SAMLProperties.Attributes.Groups();
        groups.setName(GROUPS_NAME);
        groups.setAdmin(GROUPS_ADMIN);
        final SAMLProperties.Attributes attributes = new SAMLProperties.Attributes();
        attributes.setUser(user);
        attributes.setGroups(groups);
        this.properties.setAttributes(attributes);

        final SAMLProperties.Idp idp = new SAMLProperties.Idp();
        idp.setServiceProviderMetadataURL(IDP_SERVICE_PROVIDER_METADATA_URL);
        this.properties.setIdp(idp);

        final SAMLProperties.Keystore keystore = new SAMLProperties.Keystore();
        keystore.setName(KEYSTORE_NAME);
        keystore.setPassword(KEYSTORE_PASSWORD);
        final SAMLProperties.Keystore.DefaultKey defaultKey = new SAMLProperties.Keystore.DefaultKey();
        defaultKey.setName(DEFAULT_KEY_NAME);
        defaultKey.setPassword(DEFAULT_KEY_PASSWORD);
        keystore.setDefaultKey(defaultKey);
        this.properties.setKeystore(keystore);

        final SAMLProperties.Sp sp = new SAMLProperties.Sp();
        sp.setEntityId(SP_ENTITY_ID);
        sp.setEntityBaseURL(SP_ENTITY_BASE_URL);
        this.properties.setSp(sp);

        Assert.assertThat(this.properties.getAttributes(), Matchers.is(attributes));
        Assert.assertThat(this.properties.getAttributes().getUser(), Matchers.is(user));
        Assert.assertThat(this.properties.getAttributes().getUser().getName(), Matchers.is(USER_NAME));
        Assert.assertThat(this.properties.getAttributes().getGroups(), Matchers.is(groups));
        Assert.assertThat(this.properties.getAttributes().getGroups().getName(), Matchers.is(GROUPS_NAME));
        Assert.assertThat(this.properties.getAttributes().getGroups().getAdmin(), Matchers.is(GROUPS_ADMIN));
        Assert.assertThat(this.properties.getIdp(), Matchers.is(idp));
        Assert.assertThat(
            this.properties.getIdp().getServiceProviderMetadataURL(),
            Matchers.is(IDP_SERVICE_PROVIDER_METADATA_URL)
        );
        Assert.assertThat(this.properties.getKeystore(), Matchers.is(keystore));
        Assert.assertThat(this.properties.getKeystore().getName(), Matchers.is(KEYSTORE_NAME));
        Assert.assertThat(this.properties.getKeystore().getPassword(), Matchers.is(KEYSTORE_PASSWORD));
        Assert.assertThat(this.properties.getKeystore().getDefaultKey(), Matchers.is(defaultKey));
        Assert.assertThat(this.properties.getKeystore().getDefaultKey().getName(), Matchers.is(DEFAULT_KEY_NAME));
        Assert.assertThat(
            this.properties.getKeystore().getDefaultKey().getPassword(),
            Matchers.is(DEFAULT_KEY_PASSWORD)
        );
        Assert.assertThat(this.properties.getSp(), Matchers.is(sp));
        Assert.assertThat(this.properties.getSp().getEntityId(), Matchers.is(SP_ENTITY_ID));
        Assert.assertThat(this.properties.getSp().getEntityBaseURL(), Matchers.is(SP_ENTITY_BASE_URL));
    }
}
