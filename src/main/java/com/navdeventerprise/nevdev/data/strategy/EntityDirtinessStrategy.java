package com.navdeventerprise.nevdev.data.strategy;

import org.hibernate.CustomEntityDirtinessStrategy;
import org.hibernate.Session;
import org.hibernate.persister.entity.EntityPersister;

public class EntityDirtinessStrategy implements CustomEntityDirtinessStrategy {

    @Override
    public boolean canDirtyCheck(Object entity, EntityPersister persister,
                                 Session session) {
        if (entity instanceof DirtyStateIdentifiable) {
            return true;
        }

        return false;
    }

    @Override
    public boolean isDirty(Object entity, EntityPersister persister, Session session) {
        return false;
    }

    @Override
    public void resetDirty(Object entity, EntityPersister persister, Session session) {

    }

    @Override
    public void findDirty(Object entity, EntityPersister persister, Session session, DirtyCheckContext dirtyCheckContext) {

    }
}