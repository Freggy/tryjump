package de.bergwerklabs.tryjump.core.unit;

import com.flowpowered.nbt.*;
import de.bergwerklabs.framework.schematicservice.NbtUtil;
import de.bergwerklabs.framework.schematicservice.metadata.MetadataDeserializer;
import de.bergwerklabs.tryjump.api.TryjumpUnitMetadata;
import org.bukkit.util.Vector;

/**
 * Created by Yannic Rieger on 12.02.2018.
 * <p>
 * Deserializes unit metadata.
 *
 * @author Yannic Rieger
 */
public class UnitDeserializer implements MetadataDeserializer<TryjumpUnitMetadata> {

    @Override
    public TryjumpUnitMetadata deserialize(CompoundTag compoundTag) {
        CompoundMap map      = compoundTag.getValue();
        String name          = map.get("Name").getValue().toString();
        Boolean isLite       = Boolean.valueOf(map.get("IsLite").getValue().toString());
        Integer diff         = ((IntTag)map.get("Difficulty")).getValue();
        Long created         = ((LongTag)map.get("Created")).getValue();
        Vector distanceToEnd = NbtUtil.vectorFromNbt((CompoundTag)map.get("DistanceToEnd"));
        return new TryjumpUnitMetadata(name, distanceToEnd, isLite, diff, created);
    }
}
